import com.qyf.serviceImpl.JsoupHtml;

public class JsoupApp {
	public static void main(String[] args) {       
		JsoupHtml jHtml = new JsoupHtml("http://www.jinyongwang.com/tian/");
		jHtml.getTianLongBaBu();  
     }

}
