package com.tups.service.trade;

import com.alibaba.dubbo.config.annotation.Service;
import com.tups.common.enums.BusiRetCodeEnum;
import com.tups.dao.model.TbTraderOpenApplyDO;
import com.tups.mpay.common.enums.CommonRetCodeEnum;
import com.tups.mpay.common.exceptions.CommonBizException;
import com.tups.mpay.common.parameter.ResultModel;
import com.tups.mpay.common.utils.TraceUtil;
import com.tups.enums.TraderOpenApplyStatusEnum;
import com.tups.service.trade.req.TraderOpenApplyReqDto;
import com.tups.service.trade.res.TraderOpenApplyResDto;
import com.tups.dao.repository.TbTraderOpenApplyRepository;
import com.tups.mpay.share.facade.IAesCryptFacade;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

/**
 * @describe 商户开户申请服务
 * @PROJECNAME: mpay-busi
 * @author:yudi
 * @Date: 2019/6/15 13:46
 **/
@Service(interfaceClass = ITraderOpenApplyService.class)
@Slf4j
public class TraderOpenApplyServiceImpl implements ITraderOpenApplyService {

    @Autowired
    private TbTraderOpenApplyRepository openApplyRepository;

    @Autowired
    private IAesCryptFacade aesCryptFacade;

    @Override
    public ResultModel<TraderOpenApplyResDto> getApplyInfo(TraderOpenApplyReqDto reqDto) {
        List<TbTraderOpenApplyDO> openApplyList =
            openApplyRepository.selectAllByOidPartner(reqDto.getOidPartner(), "03530000");
        if (isEmpty(openApplyList)) {
            log.info("{}未查询到开户申请记录", TraceUtil.getCorrelationID());
            throw new CommonBizException(BusiRetCodeEnum.TRADER_APPLY_NOT_EXIST);
        }
        return filterTbTraderOpenApplyDOList(openApplyList);
    }

    private ResultModel<TraderOpenApplyResDto> filterTbTraderOpenApplyDOList(List<TbTraderOpenApplyDO> openApplyList) {
        List<TbTraderOpenApplyDO> successList = openApplyList.stream()
            .filter(x -> Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.INIT.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.WAIT_REGISTER_REVIEW.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.WAIT_ENTRUST_REVIEW.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.WAIT_ENTRUST_SIGN_REVIEW.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.WAIT_SIGN.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.SIGNED.getCode()))
            .collect(Collectors.toList());
        if (!isEmpty(successList)) {
            TbTraderOpenApplyDO tbTraderOpenApply = openApplyList.get(0);
            TraderOpenApplyResDto resDto = new TraderOpenApplyResDto();
            aesDecryptData(tbTraderOpenApply);
            BeanUtils.copyProperties(tbTraderOpenApply, resDto);
            return new ResultModel(resDto, CommonRetCodeEnum.TRANS_SUCCESS.getCode(),
                CommonRetCodeEnum.TRANS_SUCCESS.getDesc());
        }
        List<TbTraderOpenApplyDO> errorList = openApplyList.stream()
            .filter(x -> Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.REGISTER_REVIEW_REFUSE.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.ENTRUST_REVIEW_REFUSE.getCode())
                || Objects.equals(x.getStatus(), TraderOpenApplyStatusEnum.ENTRUST_SIGN_REVIEW_FAILED.getCode()))
            .collect(Collectors.toList());
        if (!isEmpty(errorList)) {
            TbTraderOpenApplyDO tbTraderOpenApply = errorList.get(0);
            TraderOpenApplyResDto resDto = new TraderOpenApplyResDto();
            BeanUtils.copyProperties(tbTraderOpenApply, resDto);
            return new ResultModel(resDto, CommonRetCodeEnum.TRANS_SUCCESS.getCode(),
                CommonRetCodeEnum.TRANS_SUCCESS.getDesc());
        }
        throw new CommonBizException(BusiRetCodeEnum.TRADER_APPLY_NOT_EXIST);
    }

    private void aesDecryptData(TbTraderOpenApplyDO openApplyDO) {
        if (openApplyDO == null) {
            return;
        }

        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceName())) {
            openApplyDO.setFinanceName(aesCryptFacade.aesDecrypt(openApplyDO.getFinanceName()));
        }

        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceMobile())) {
            openApplyDO.setFinanceMobile(aesCryptFacade.aesDecrypt(openApplyDO.getFinanceMobile()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceIdNo())) {
            openApplyDO.setFinanceIdNo(aesCryptFacade.aesDecrypt(openApplyDO.getFinanceIdNo()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getBankAccount())) {
            openApplyDO.setBankAccount(aesCryptFacade.aesDecrypt(openApplyDO.getBankAccount()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getRegisterJson())) {
            openApplyDO.setRegisterJson(aesCryptFacade.aesDecrypt(openApplyDO.getRegisterJson()));
        }
    }

}
