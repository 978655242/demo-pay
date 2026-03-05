package com.lianlianpay.mpay.busidemo.dto.trade;

import com.lianlianpay.mpay.common.parameter.BaseReqDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @describe ${输入类的描述}
 * @PROJECNAME: demo
 * @author:yudi
 * @Date: 2019/6/15 13:48
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraderOpenApplyReqDto extends BaseReqDTO  {

	@NotBlank(message = "商户号不能为空")
	private String oidPartner;

	@Override
	public String validateLogic() {
		return null;
	}
}
