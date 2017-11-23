package pl.coderslab.majsna.WyszukiwarkaSlow;

public class Word implements Comparable<Word>{
	
	private Integer counter;
	private String word;
	
	public Word(Integer counter, String word) {
		this.counter = counter;
		this.word = word;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public int compareTo(Word o) {
		return o.counter.compareTo(this.counter);
	}
	
	public String toString() {
		return "word: "+"\""+this.word+"\""+" counter: "+this.counter;
	}
	
	
	
	
	
	

}
