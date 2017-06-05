package spring.ioc01;

public class Pan implements Juggler {

	private Poem poem;

	private int num;

	public Pan() {
	}

	public Pan(Poem poem, int num) {
		this.poem = poem;
		this.num = num;
	}





	public Poem getPoem() {
		return poem;
	}





	public void setPoem(Poem poem) {
		this.poem = poem;
	}





	public int getNum() {
		return num;
	}





	public void setNum(int num) {
		this.num = num;
	}





	@Override
	public void perform() {
		System.out.print("我在耍杂技,丢了" + num + "个球,并且正在 ");
		poem.recite();
	}

}
