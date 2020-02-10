/**
 * 干员简历类
 */
package africanights.model;


public class Resume {
	
	protected String m_name = "";//干员姓名
	protected String m_codename = "";//干员代号
	protected int m_star = 0;//干员星级
	protected String m_chat = "";//台词
	protected Profession m_profession = Profession.UNKNOWN;//职业
	protected String m_portrayal = "";//立绘路径
	
	public Resume(String name,int star,String chat,String portrayal,String codename,Profession profession) {
		m_name = name;
		m_star = star;
		m_chat = chat;
		m_portrayal = portrayal;
		m_codename = codename;
		m_profession = profession;
	}

	public Profession getProfession() {
		return m_profession;
	}

	public void setProfession(Profession profession) {
		this.m_profession = profession;
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

	public String getCodename() {
		return m_codename;
	}

	public void setCodename(String codename) {
		this.m_codename = codename;
	}

	public void show() {
		System.out.format("%s\n", m_portrayal);
		System.out.format("[%s|%s](%s星%s)%s\n", m_name,m_codename,String.valueOf(m_star),m_profession.getDesc(),m_chat);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
