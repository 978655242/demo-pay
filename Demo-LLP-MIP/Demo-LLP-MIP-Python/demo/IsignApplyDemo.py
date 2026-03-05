import logging
log = logging.getLogger('IsignApplyDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from utils.LLianPayDateUtils import LLianPayDateUtils
from v1.isign.argument.apply.ApplyParams import ApplyParams
from v1.info.CardInfo import CardInfo

params=ApplyParams()
params.mch_id = MchId
params.user_id="pWDslsPANCa4rimg0byYcXR4F8avAF08"
params.txn_seqno="SOgKCGouScflQDsTw6I8Nm11DzTZEn5n"
params.txn_time=LLianPayDateUtils.get_timestamp()

card_info =CardInfo()

card_info.acct_name="FVQ/g1Y8Uhp6tLt4D1R9dTNiFBZN4iO4hA01DyACm7EwhE/mqXAU3D4VCjXBRcIrCtSaxISk4vaGxwFi41KCo6DcQi1b75JxvjZgrBybbmNGdQY2BG94J2+kTv3ThZr5Ucd50P3J7MPPVX+pqe1tXWHHJu4OcE3iPDdFsweb7kU="
card_info.id_no="HX+puVp2jeYBnD/shX1w8cmCjKfhOyXRdz3dWhMy4N+5MJ388vnDGcIiEypRp65fWXpWHkSm10sMEGv7AmO0cIaHh7JKKZhmoke3Vhx1SNgwEiZjqRGbCVqfSlBy59Uz4puuetfexao+8Leduhx/MoqVtbCD46k1IP92lww9O6s="
card_info.id_type="IDCARD"
card_info.bind_phone="UlAxVPOj7abTfJ1Py6wRe5h+wdLqH+z10Dcg/xrlGQe5POs+QK7RHVEGRI5P/a6Z/eCsp366+Gd8kTGnv81/hI8WYqBB2BqpH2F65nNcBe9B6DfTAE01xcYTWxXNNl8D1INnh1mhg15WPe75VLfpXV7dwjCPiRJomp0uPvcVeYM="
card_info.card_no="JZ0jbXJamppAQzc+q4WlXNTaZbqqEho8irtGKkSFab/8pxKBavnY6rmVBDFFG0FwKPegcJ9et5dtMvXsUkMY6Ibpmw5rgbSVR+cmRAsyx6Sx7qKLEnzA8Ihr0JcjC1hyJzk7hbKnsvKH9495faB5pNAAAc0Q6QIrAURTMYcZNCo="
params.card_info=card_info

url = "https://test.lianlianpay-inc.com/mch/v1/isign/apply/"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)
