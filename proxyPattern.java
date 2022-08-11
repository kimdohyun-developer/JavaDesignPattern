interface Subject{
	public void DoAction();
}

class RealSubject implements Subject{
	private String name;
	
	//생성자
	RealSubject(String name){
		this.name=name;
	}
	
	private void loadFromDisk(String name) {
		System.out.println("loading: "+name);
	}

	@Override
	public void DoAction() {
		loadFromDisk(name);
		System.out.println("show: "+name); //인터페이스의 추상메소드를 오버라이딩 해서 구현
	}
}

//proxy가 realSubject에 대한 객체를 대신 만들어서 
//subject에서 직접  realsubject에 접근하는 것이 아닌 proxy를 통해 간접적으로 사용할 수 있게 만든다.
//과정: Subject->Proxy->RealSubject
class Proxy implements Subject{
	private String name;
	private RealSubject RealSub;
	
	//생성자
	Proxy(String name){
		this.name=name;
	}
	
	//추상메소드의 구현
	@Override
	public void DoAction() {
		if(RealSub == null) {
			RealSub = new RealSubject(name);
		}
		RealSub.DoAction();
	}
}

public class proxyPattern {

	public static void main(String[] args) {
		Subject s1 = new Proxy("file1.exe");
		Subject s2 = new Proxy("file2.exe");
		
		s1.DoAction();
		System.out.println("");
		s2.DoAction();
	}
}

//프록시는 어떤 객체를 사용하고자 할때, 객체를 직접적으로 참조하는 것이 아니라
//해당 객체를 대행하는 객체를 통해 대상객체에 접근 한느 방식을 사용하면 
//해당 객체가 메모리에 존재하지 않아도 기본적인 정보를 참조하거나 설정할 수 있고
//또한 실제 객체의 기능이 반드시 필요한 시점까지 객체의 생성을 미룰 수 있다.

//프록시의 종류
//가상프록시, 원격프록시, 보호프록시

