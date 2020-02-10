/**
 * 卡池类
 * 负责存储卡池概率信息
 */

package africanights.model;


import java.io.File;
import java.util.Random;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Pool {
	
	protected double[] m_starProbability = new double[] {
			0.00,
			0.00,0.00,//1,2星
			0.40,0.50,//3,4星
			0.08,0.02//5,6星
	};//星级出率，下标1~6对应星级，0暂时闲置
	
	//简历池：二维数组，一维下标对应星级，二维下标动态，值为简历引用
	protected Vector<Resume>[] m_resumePool = new Vector[7];
	
	/**
	 * 初始化简历池，将存储在xml文件中的简历信息读取到简历池中。
	 * 
	 */
	public void initResumePool() {
		//初始化简历池对象
		for(int i=0;i<m_resumePool.length;i++) {
			m_resumePool[i] = new Vector<Resume>();
		}
		//载入所有简历
		String resumeDirPath = "config\\resume";
		File resumeDir = new File(resumeDirPath);
		//String[] resumeList = resumeDir.list();//读取简历的文件名
		File[] resumeList = resumeDir.listFiles();//直接返回文件
		
		for(int i=0;i<resumeList.length;i++) {
			loadResume(resumeList[i]);//载入简历
		}
		
		
		
	}
	
	
	/**
	 * 载入简历对象
	 * @param path 简历文件路径
	 * @return 简历对象
	 */
	public Resume loadResume(String path) {
		File file = new File(path);
		return loadResume(file);//为了只保留一个解析方式修改点
	}
	
	/**
	 * 载入单个简历
	 * @param file 简历文件对象
	 * @return 简历对象
	 */
	public Resume loadResume(File file) {
		Resume resume = null;
		try{
			//解析xml文件
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			
			String nameString= doc.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			String starString= doc.getElementsByTagName("star").item(0).getFirstChild().getNodeValue();
			int starInt = Integer.valueOf(starString);
			String chatString= doc.getElementsByTagName("chat").item(0).getFirstChild().getNodeValue();
			String portrayalString= doc.getElementsByTagName("portrayal").item(0).getFirstChild().getNodeValue();
			
			String codenameString = doc.getElementsByTagName("codename").item(0).getFirstChild().getNodeValue();
			String professionString = doc.getElementsByTagName("profession").item(0).getFirstChild().getNodeValue();
			professionString = professionString.toUpperCase();
			
			resume = new Resume(nameString, starInt, chatString, portrayalString,codenameString,Profession.valueOf(professionString));
			resume.show();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resume;
	}

	
	/**
	 * 根据星级概率抽取出一个星级，取值为1~6
	 * @return 干员星级
	 */
	public int randomStar() {
		Random random = new Random();
		int star = 0;//返回值
		
		int randomInt = random.nextInt(100) + 1;//产生[1,100]之间的随机数
		//判断星级区间
		/**
		 * 每一个星级根据概率大小占据[1,100]区间不同长度的区间，
		 * 判断随机数落在哪个区间，就是抽取到了哪个星级
		 * 
		 */
		int lowerInt=1;//边界整数，用于给星级区域定界
		int upperInt=1;
		for(int i=1;i<m_starProbability.length;i++) {
			lowerInt = upperInt;//上一个星级的上界变为这个星级的下界
			int areaLength = (int)Math.round(m_starProbability[i] * 100);
			upperInt += areaLength;
			if(lowerInt <= randomInt && randomInt < upperInt) {
				//如果随机数落在[lowerInt,upperInt)区间
				star = i;
				break;
			}
		}
		
		//单独处理抽到100的情况
		//抽到100则为最高星级
		if(randomInt == 100) return m_starProbability.length-1;
		return star;
	}
	
	
	
	
	public static void main(String[] args) {
		/*/测试randomStar()
		Pool pool = new Pool();
		int[] counter=new int[7];
		for(int i=0;i<100;i++) {
			int star = pool.randomStar();//测试randomStar()
			System.out.format("%d\n",star);
			counter[star]++;
		}
		for(int i=0;i<7;i++) {
			System.out.format("抽到%d星%d个\n",i,counter[i]);
		}
		//测试randomStar()*/

		//测试initResumePool()
		Pool pool = new Pool();
		pool.initResumePool();
		//pool.loadResume("config\\resume\\Melantha.xml");
		//测试initResumePool()*/
		
	}

}
