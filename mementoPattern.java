package designPatternPkg;

import java.util.Stack; //스택 자료구조 라이브러리 

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
		return this.state; //this.는 그 객체의 값을 반환하는 것 
	}
}
//Memento클래스가 간단하기 때문에 careTaker클래스는 스택 자료구조를 사용한다.
public class mementoPattern {

	public static void main(String[] args) {
		
		//메멘토패턴은 행위(behavioral)패턴중 하나로써 특정 시점에서의 객체 내부 상태를 
		//객체화함으로써 이후 요청에 따라 객체를 해당 시점의 상태로 돌릴 수 있는 기능을 제공하는 패턴이다.
		
		
		//originator: 현재상태를 표현하는 state를 가지고 있으며 memento 객체를 통해 현재상태를 변경
		//memento: originator의 상태를 나타내는 클래스, memento를 이용하여 originator의 상태를 변경
		//careTaker: memento를 순서대로 저장하여 관리하는 클래스, stack이나 list같은 자료구조를 사용해도 무방하다.
		
		Originator originator = new Originator();
		Stack<Memento> mementos = new Stack<>(); //이부분이 careTaker 를 대신할 부분이다.

		//스텍에 자료들을 쌓는 거다.
		originator.setState("A");
		mementos.push(originator.createMemento());
		originator.setState(originator.getState()+"B");
		mementos.push(originator.createMemento());
		originator.setState(originator.getState()+"C");
		mementos.push(originator.createMemento());
		originator.setState(originator.getState()+"D");
		mementos.push(originator.createMemento());
		
		while(!mementos.isEmpty()) //스택이 비지 않으면 계속 실행한다는 것.
		{
			originator.restoreMemento(mementos.pop()); //스택을 하나씩 뺴는것. - 스택이 빌때까지.
			System.out.println(originator.getState()); //하나씩 뺴면서 출력.
		}
		
		
	}

}
