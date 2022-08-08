package designPatternPkg;

interface engine
{
}

class engineA implements engine
{
	public engineA()
	{
		System.out.println("engineA����");
	}
}

class engineB implements engine
{
	public engineB()
	{
		System.out.println("engineB����");
	}
}

interface handle
{
}

class handleA implements handle
{
	public handleA()
	{
		System.out.println("handleA����");
	}
}

class handleB implements handle
{
	public handleB()
	{
		System.out.println("handleB����");
	}
}

interface carFactory
{
	public engine createEngine(); //�������̽��� Ư¡������ abstract�� ������ �ʾƵ� 
	public handle createHandle(); //�߻�޼ҵ尡 �ȴ�.
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
			System.out.println("�������� �ʽ��ϴ�.");
			break;
		}
		carFactory.createEngine();
		carFactory.createHandle();
	}
}
public class abstractFactroyPattern {
	public static void main(String[] args) {
		//�߻� ���丮 ������ ���� ������ �ִ� ��ü���� ��°�� ��� ���丮 Ŭ������ �����,
		//�̵� ���丮�� ���ǿ� ���� �����ϵ��� ���丮�� ���� ��ü�� �����ϴ� �����̴�.
		//��� ����, ���丮 �޼ҵ� ������ �� �� ĸ��ȭ�� ����̶�� �� �� �ִ�.
		
		//���丮 �޼ҵ� ���ϰ��� ����
		//�����ϴ� Ŭ������ �߰���.
		//�ϰ��� ��ü����
		
		factoryOfCarFactory F1 = new factoryOfCarFactory(); 
		factoryOfCarFactory F2 = new factoryOfCarFactory(); 
		F1.createCar("A");
		F2.createCar("B");
		
		//���丮 �޼ҵ� ���Ͽ����� ����ǰ���� ���丮�� ���� � ��ü�� �����ߴµ� 
		//�� ��ü�� ����ǰ�� �����ϹǷ� �߻� ���丮 ������ �����Ͽ� ���õ� ��ü����
		//�Ѳ����� ĸ��ȭ�Ͽ� ���丮�� ���� �ϰ��ǰ� ��ü�� �����ϵ��� �Ѵ�.
	}

}

