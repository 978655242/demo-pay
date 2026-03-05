# LLP-MIP-Python
欢迎来到连连聚数开放平台API接口的Python示例代码仓库，本仓库包含示例代码及必要的说明。
## 主要内容：
本仓库中所有Demo仅做参考，请仔细阅读Demo代码，如有问题及时联系连连技术。
### 前置要求：
本项目基于python3.10实现，python3应均可调用
### 使用说明
1、config/LLianPayConstant.py 保存测试商户号、测试商户号对应私钥、连连公钥，可视情况进行替换。  
2、security/LLianPayMipSignature.py 包含签名、验签、本地加密方法。  
3、client/LLianPayClient.py 发起请求方法。  
4、v1目录下包含实体对象、响应对象等参数对象。  
5、部分Demo是无法直接运行的，需要在代码中添加相应个人信息后方可运行（证件号、银行卡号等）。