package designPatternPkg;

import java.util.Stack; //���� �ڷᱸ�� ���̺귯�� 

class Originator
{
	private String state;
	
	public Memento createMemento()
	{
		return new Memento(state);
	}
	
	public void restoreMemento(Memento Memento)
	{
		this.state=Memento.getState();
	}
	
	public String getState()
	{
		return this.state;
	}
	
	public void setState(String state)
	{
		this.state=state;
	}
	
}

class Memento
{
	private String state;
	
	public Memento(String state)
	{
		this.state=state;
	}
	
	public String getState()
	{
		return this.state; //this.�� �� ��ü�� ���� ��ȯ�ϴ� �� 
	}
}
//MementoŬ������ �����ϱ� ������ careTakerŬ������ ���� �ڷᱸ���� ����Ѵ�.
public class mementoPattern {

	public static void main(String[] args) {
		
		//�޸��������� ����(behavioral)������ �ϳ��ν� Ư�� ���������� ��ü ���� ���¸� 
		//��üȭ�����ν� ���� ��û�� ���� ��ü�� �ش� ������ ���·� ���� �� �ִ� ����� �����ϴ� �����̴�.
		
		
		//originator: ������¸� ǥ���ϴ� state�� ������ ������ memento ��ü�� ���� ������¸� ����
		//memento: originator�� ���¸� ��Ÿ���� Ŭ����, memento�� �̿��Ͽ� originator�� ���¸� ����
		//careTaker: memento�� ������� �����Ͽ� �����ϴ� Ŭ����, stack�̳� list���� �ڷᱸ���� ����ص� �����ϴ�.
		
		Originator originator = new Originator();
		Stack<Memento> mementos = new Stack<>(); //�̺κ��� careTaker �� ����� �κ��̴�.

		//���ؿ� �ڷ���� �״� �Ŵ�.
		originator.setState("A");
		mementos.push(originator.createMemento());
		originator.setState(originator.getState()+"B");
		mementos.push(originator.createMemento());
		originator.setState(originator.getState()+"C");
		mementos.push(originator.createMemento());
		originator.setState(originator.getState()+"D");
		mementos.push(originator.createMemento());
		
		while(!mementos.isEmpty()) //������ ���� ������ ��� �����Ѵٴ� ��.
		{
			originator.restoreMemento(mementos.pop()); //������ �ϳ��� ���°�. - ������ ��������.
			System.out.println(originator.getState()); //�ϳ��� ���鼭 ���.
		}
		
		
	}

}
