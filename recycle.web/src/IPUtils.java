import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 新浪的IP地址查询接口：http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js

新浪多地域测试方法：http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip=218.192.3.42

搜狐IP地址查询接口（默认GBK）：http://pv.sohu.com/cityjson

搜狐IP地址查询接口（可设置编码）：http://pv.sohu.com/cityjson?ie=utf-8

搜狐另外的IP地址查询接口：http://txt.go.sohu.com/ip/soip

淘宝： http://ip.taobao.com/service/getIpInfo.php?ip=211.138.125.150

上面的接口中新浪的是js接口说明：

<script type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js" charset="gb2312"></script>
<script type="text/javascript">
function ipmsg() {
var ss = remote_ip_info['country']  + remote_ip_info['province']+ remote_ip_info['city'];
document.getElementByIdx_x_x("<%=HiddenField1.ClientID %>").value = ss;

}
</script>

 
 * @author tangxiucai
 *
 */

public class IPUtils {
	public static void main(String[] args)  {
		/*for(int ip1=193; ip1<=255; ip1++){
			for(int ip2=0; ip2<=255; ip2++){
				for(int ip3=0; ip3<=255; ip3++){
					for(int ip4=0; ip4<=255; ip4++){
						try {
							System.out.println(getInfo(ip1+"."+ip2+"."+ip3+"."+ip4));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}*/
		
		for(int ip1=202; ip1<=202; ip1++){ //202.255.255.0 - 202.255.255.255  日本
			for(int ip2=255; ip2<=255; ip2++){
				for(int ip3=255; ip3<=255; ip3++){
					for(int ip4=0; ip4<=255; ip4++){
						try {
							System.out.println(getInfo(ip1+"."+ip2+"."+ip3+"."+ip4));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public static String getInfo(String ip)throws MalformedURLException, IOException{
		URLConnection c = new URL("http://int.dpool.sina.com.cn/iplookup/iplookup.php?ip="+ip).openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "GBK"));
		String line;
		for(line = br.readLine(); line!=null; line = br.readLine())
			return (ip+":"+line);
		return null;
	}
}
