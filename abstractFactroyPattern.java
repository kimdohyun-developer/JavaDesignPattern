interface engine
{
}

class engineA implements engine
{
	public engineA()
	{
		System.out.println("engineA생성");
	}
}

class engineB implements engine
{
	public engineB()
	{
		System.out.println("engineB생성");
	}
}

interface handle
{
}

class handleA implements handle
{
	public handleA()
	{
		System.out.println("handleA생성");
	}
}

class handleB implements handle
{
	public handleB()
	{
		System.out.println("handleB생성");
	}
}

interface carFactory
{
	public engine createEngine(); //인터페이스의 특징때문에 abstract를 붙이지 않아도 
	public handle createHandle(); //추상메소드가 된다.
}

class AFactory implements carFactory
{
	@Override
	public engineA createEngine() {
		// TODO Auto-generated method stub
		return new engineA();
	}

	@Override
	public handleA createHandle() {
		// TODO Auto-generated method stub
		return new handleA();
	}
}

class BFactory implements carFactory
{
	@Override
	public engineB createEngine() {
		// TODO Auto-generated method stub
		return new engineB();
	}

	@Override
	public handleB createHandle() {
		// TODO Auto-generated method stub
		return new handleB();
	}
}

class factoryOfCarFactory
{
	void createCar(String type)
	{
		carFactory carFactory = null;
		switch(type)
		{
		case"A":
			carFactory = new AFactory();
			break;
		case"B":
			carFactory = new BFactory();
			break;
		default:
			System.out.println("존재하지 않습니다.");
			break;
		}
		carFactory.createEngine();
		carFactory.createHandle();
	}
}
public class abstractFactroyPattern {
	public static void main(String[] args) {
		//추상 펙토리 패턴은 서로 관련이 있는 객체들을 통째로 묶어서 팩토리 클래스를 만들고,
		//이들 펙토리를 조건에 따라 생성하도록 펙토리를 만들어서 객체를 생성하는 패턴이다.
		//어떻게 보면, 펙토리 메소드 패턴을 좀 더 캡슐화한 방식이라고 볼 수 있다.
		
		//펙토리 메소드 패턴과의 차이
		//선택하는 클래스가 추가됨.
		//일괄된 객체생성
		
		factoryOfCarFactory F1 = new factoryOfCarFactory(); 
		factoryOfCarFactory F2 = new factoryOfCarFactory(); 
		F1.createCar("A");
		F2.createCar("B");
		
		//펙토리 메소드 패턴에서는 구성품마다 펙토리를 만들어서 어떤 객체를 형성했는데 
		//그 객체의 구성품은 일정하므로 추상 펙토리 패턴을 적용하여 관련된 객체들을
		//한꺼번에 캡슐화하여 펙토리로 만들어서 일관되게 객체를 생성하도록 한다.
	}

}

