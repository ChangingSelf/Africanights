/**
 * 卡池类
 * 负责存储卡池概率信息
 */

package africanights.model;


import java.util.Random;

public class Pool {
	
	protected double[] m_starProbability = new double[] {
			0.00,0.00,0.00,//1,2星
			0.40,0.50,//3,4星
			0.08,0.02//5,6星
	};//星级出率，下标1~6对应星级，0暂时闲置

	
	
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
		//测试randomStar()
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

	}

}
