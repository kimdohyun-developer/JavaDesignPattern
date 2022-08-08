package designPatternPkg;

abstract class Car{
	
	void start_car() //���ø� �޼ҵ�
	{
		info();
		fire(); //�Ϸ��� ������ �����ؼ� ����ؾ��� ��� �̷��� ����ϴ� ���� �� ���ϴ�.
		rpm();
		drive();
	}
	
	void fire()
	{
		System.out.println("������ �۵��մϴ�.");
	}
	void rpm()
	{
		System.out.println("�������� ȸ������ �����߽��ϴ�.");
	}
	void drive()
	{
		System.out.println("������ �����մϴ�.");
	}
	abstract void info(); //�߻�޼ҵ�ν� �ۿ��� �������̵��Ͽ� ����� ���̴�.
}

class Granger extends Car //��ӽ��Ѽ� �ڽ� Ŭ�������� �θ�Ŭ������ �޼ҵ带 ����� �� �ְ� �Ѵ�
{
	public void info() //�߻�޼ҵ��� �籸��
	{
		System.out.println("���� �׷���");
	}
}
class Porsche911 extends Car
{
	public void info() 
	{
		System.out.println("������911");
	}
}
class Beetle extends Car
{
	public void info()  
	{
		System.out.println("�����ٰ� ��Ʋ");
	}
}



public class templateMethod {

	public static void main(String[] args) {
		//���ø� �޼ҵ� ������ �˰����� ������ �޼ҵ忡 �����ϰ� ���� Ŭ�������� �˰��� ������ ������� �˰����� �������Ѵ�.
		//�˰����� �ܰ躰�� ���������ų�, ���� ������ �ϴ� �޼ҵ������� ���������� �ٸ� ���·� ����� �ʿ��� ��� �����ϸ� ����� ���� ����(�θ�)Ŭ������ ����� Ȯ���ϱ⿡ �����ϴ�.
		//������ �ʴ� ����� ����Ŭ������ �����ΰ� ���� �����ϰ� Ȯ���� ����� ���� Ŭ������ ����� �ȴ�.

		Granger c1 = new Granger(); 
		Porsche911 c2 = new Porsche911();
		Beetle c3 = new Beetle();
		
		c1.start_car(); //�̷��� ���ø� �޼ҵ带 �ҷ��´�.
		c2.start_car();
		c3.start_car();
	}

}

//����-�ߺ��ڵ带 ���� �� �ִ�, �ڽ� Ŭ������ ������ �ٿ� �ٽ� ������ ������ �����ϴ�, ���� �ڵ带 ��ü���������� ������ �� �ִ�.
//����-�߻�޼ҵ尡 �������� ������ ��ƴ�, Ŭ�������� �����ڵ尡 �������� ����� �ִ�.