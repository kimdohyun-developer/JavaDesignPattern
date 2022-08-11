package designPatternPkg;


interface Subject{
	public void DoAction();
}

class RealSubject implements Subject{
	private String name;
	
	//������
	RealSubject(String name){
		this.name=name;
	}
	
	private void loadFromDisk(String name) {
		System.out.println("loading: "+name);
	}

	@Override
	public void DoAction() {
		loadFromDisk(name);
		System.out.println("show: "+name); //�������̽��� �߻�޼ҵ带 �������̵� �ؼ� ����
	}
}

//proxy�� realSubject�� ���� ��ü�� ��� ���� 
//subject���� ����  realsubject�� �����ϴ� ���� �ƴ� proxy�� ���� ���������� ����� �� �ְ� �����.
//����: Subject->Proxy->RealSubject
class Proxy implements Subject{
	private String name;
	private RealSubject RealSub;
	
	//������
	Proxy(String name){
		this.name=name;
	}
	
	//�߻�޼ҵ��� ����
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

//���Ͻô� � ��ü�� ����ϰ��� �Ҷ�, ��ü�� ���������� �����ϴ� ���� �ƴ϶�
//�ش� ��ü�� �����ϴ� ��ü�� ���� ���ü�� ���� �Ѵ� ����� ����ϸ� 
//�ش� ��ü�� �޸𸮿� �������� �ʾƵ� �⺻���� ������ �����ϰų� ������ �� �ְ�
//���� ���� ��ü�� ����� �ݵ�� �ʿ��� �������� ��ü�� ������ �̷� �� �ִ�.

//���Ͻ��� ����
//�������Ͻ�, �������Ͻ�, ��ȣ���Ͻ�

