package africanights.model;

/**
 * 人力资源类
 * @author ChangingSelf
 *
 */
public class HumanResource {
	
	//招聘用物资数目
	private int m_compositeJade = 600000000;//合成玉
	private int m_recruitCertificate = 0;//寻访凭证
	private int m_tenfoldRecruitCertificate = 1;//十连寻访凭证
	
	//卡池
	private Pool m_pool = new Pool();
	
	/**
	 * 单抽
	 * @return 单抽简历
	 */
	public Resume singleRecruit() {
		if(m_recruitCertificate >= 1) {
			m_recruitCertificate--;//有寻访凭证就先用寻访凭证
		}
		else if(m_compositeJade >= m_pool.getCompositeJadeCost() ) {
			m_compositeJade -= m_pool.getCompositeJadeCost();//扣除合成玉
		}
		
		
		return m_pool.randomResume();
	}
	
	
	/**
	 * 十连
	 * @return 十连简历组
	 */
	public Resume[] tenfoldRecruit() {
		if(m_tenfoldRecruitCertificate >= 1) {
			m_tenfoldRecruitCertificate--;//有寻访凭证就先用寻访凭证
		}
		else if(m_compositeJade >= m_pool.getCompositeJadeCost()*10 ) {
			m_compositeJade -= m_pool.getCompositeJadeCost()*10;//扣除合成玉
		}
		
		
		Resume[] tenfoldResumes = new Resume[10];
		for(int i=0;i<10;i++) {
			tenfoldResumes[i] = m_pool.randomResume();
		}
		return tenfoldResumes;
	}
	
	public void showResource() {
		System.out.printf("合成玉：%d\t寻访凭证：%d\t十连寻访凭证：%d\n", m_compositeJade,m_recruitCertificate,m_tenfoldRecruitCertificate);
	}

	public static void main(String[] args) {
		HumanResource hr = new HumanResource();
		hr.showResource();
		
		Resume[] resumes = hr.tenfoldRecruit();
		for(Resume resume:resumes) {
			System.out.printf("[%s]",resume.getName());
		}
		System.out.println();
		hr.showResource();

	}

}
