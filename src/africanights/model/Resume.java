/**
 * 干员简历类
 */
package africanights.model;

public class Resume {
	
	protected String m_name = "";//干员代号
	protected int m_star = 0;//干员星级
	protected String m_chat = "";//台词
	protected String m_portrayal = "";//立绘路径
	
	public Resume(String name,int star,String chat,String portrayal) {
		m_name = name;
		m_star = star;
		m_chat = chat;
		m_portrayal = portrayal;
	}

	public String getName() {
		return m_name;
	}


	public void setName(String name) {
		this.m_name = name;
	}


	public int getStar() {
		return m_star;
	}


	public void setStar(int star) {
		this.m_star = star;
	}


	public String getChat() {
		return m_chat;
	}


	public void setChat(String chat) {
		this.m_chat = chat;
	}


	public String getPortrayal() {
		return m_portrayal;
	}


	public void setPortrayal(String portrayal) {
		this.m_portrayal = portrayal;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
