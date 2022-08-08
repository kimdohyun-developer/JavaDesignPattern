package designPatternPkg;

class type
{
	//�ٵ� ����.
}
class typeA extends type //���
{
	public typeA()
	{
		System.out.println("A�� ��ü�� ������");
	}
}

class typeB extends type
{
	public typeB()
	{
		System.out.println("B�� ��ü�� ������");
	}
}

class typeC extends type
{
	public typeC()
	{
		System.out.println("C�� ��ü�� ������");
	}
}

class factory
{
	public type factoryMethod(String type)
	{
		type typeReturn = null;
		switch(type)
		{
		case"A":
			typeReturn = new typeA();
			break;
		case"B":
			typeReturn = new typeB();
			break;
		case"C":
			typeReturn = new typeC();
			break;
			
		default:
		    System.out.println("�Է��� �̸��� Ŭ������ �������� �ʽ��ϴ�.");
            break;		
		}
		return typeReturn;
	}
}
public class factoryMethod {
	public static void main(String[] args) {
		//���丮 �޼ҵ� ����(factory method pattern)
		//� ��Ȳ���� ���ǿ� ���� ��ü�� �ٸ��� �����ؾ� �� ���� �ֽ��ϴ�.
		//���� ���, ������� �Է°��� ���� �ϴ� ���� �޶��� ���
		
		//���丮 �޼ҵ�� ���丮��� Ŭ������ ��ü������ �����Ͽ� ���丮 Ŭ������ ��ü�� �����ϵ��� �ϴ� ����̴�.
		//���״�� ����!
		
		factory C1 = new factory();
		C1.factoryMethod("A"); //�̷������� �ܺο��� ������ ��ü�� �ҷ����� �ʾƵ� ���丮 �޼ҵ带 ����ϸ� �����ϰ� �ҷ��� �� �ִ�.
		C1.factoryMethod("B");
		C1.factoryMethod("C");
		C1.factoryMethod("D");

	}
}
