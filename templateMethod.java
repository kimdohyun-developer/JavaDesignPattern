package designPatternPkg;

abstract class Car{
	
	void start_car() //템플릿 메소드
	{
		info();
		fire(); //일런의 순서를 지정해서 사용해야할 경우 이렇게 사용하는 것이 더 편리하다.
		rpm();
		drive();
	}
	
	void fire()
	{
		System.out.println("엔진이 작동합니다.");
	}
	void rpm()
	{
		System.out.println("안정적인 회전수에 도달했습니다.");
	}
	void drive()
	{
		System.out.println("주행이 가능합니다.");
	}
	abstract void info(); //추상메소드로써 밖에서 오버라이딩하여 사용할 것이다.
}

class Granger extends Car //상속시켜서 자식 클래스에서 부모클래스의 메소드를 사용할 수 있게 한다
{
	public void info() //추상메소드의 재구현
	{
		System.out.println("현대 그랜저");
	}
}
class Porsche911 extends Car
{
	public void info() 
	{
		System.out.println("포르쉐911");
	}
}
class Beetle extends Car
{
	public void info()  
	{
		System.out.println("폭스바겐 비틀");
	}
}



public class templateMethod {

	public static void main(String[] args) {
		//템플릿 메소드 패턴은 알고리즘의 구조를 메소드에 정의하고 하위 클래스에서 알고리즘 구조의 변경없이 알고리즘을 재정의한다.
		//알고리즘이 단계별로 나누어지거나, 같은 역할을 하는 메소드이지만 여러곳에서 다른 형태로 사용이 필요한 경우 유용하며 상속을 통해 상위(부모)클래스의 기능을 확장하기에 용이하다.
		//변하지 않는 기능은 상위클래스에 만들어두고 자주 변경하고 확장할 기능은 하위 클래스에 만들면 된다.

		Granger c1 = new Granger(); 
		Porsche911 c2 = new Porsche911();
		Beetle c3 = new Beetle();
		
		c1.start_car(); //이렇게 템플릿 메소드를 불러온다.
		c2.start_car();
		c3.start_car();
	}

}

//장점-중복코드를 줄일 수 있다, 자식 클래스의 역할을 줄여 핵심 로직의 관리가 용이하다, 좀더 코드를 객체지향적으로 구성할 수 있다.
//단점-추상메소드가 많아지면 관리가 어렵다, 클래스간의 관계코드가 꼬여버릴 우려가 있다.