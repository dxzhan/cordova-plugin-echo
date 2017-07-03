import Foundation

@objc(HWPEchoPlugin) class EchoPlugin : CDVPlugin {

    //加法运算
    @objc(echo:)
    func echo(command:CDVInvokedUrlCommand)
    {
        var pluginResult = CDVPluginResult(
            status:CDVCommandStatus_ERROR
        )

        print("11111111111111")

        //获取参数
        let msg = command.arguments[0] as? String ?? "";

        if msg == nil || msg == "" {
            pluginResult = CDVPluginResult(status:CDVCommandStatus_ERROR,messageAs:"输入参数为空")
        }
        else{
            print("js message=" + msg)
        }
        //返回结果
        pluginResult = CDVPluginResult(status:CDVCommandStatus_OK,messageAs: msg)

        //发送结果
        self.commandDelegate.send(pluginResult, callbackId: command.callbackId)
    }
}
