package africanights.model;

/**
 * 干员职业枚举
 * @author ChangingSelf
 *
 */
public enum Profession {
	UNKNOWN("未知职业"),//未知
	VANGUARD("先锋"),//先锋
	SNIPER("狙击"),//狙击
	MEDIC("医疗"),//医疗
	GUARD("近卫"),//近卫
	WIZARD("术师"),//术师
	DEFENDER("重装"),//重装
	SUPPORTER("辅助"),//辅助
	SPECIALIST("特种");//特种
	
	private String desc;//中文描述
	
	private Profession(String desc) {
		this.desc=desc;
	}
	
	public String getDesc() {
		return desc;
	}
	public static void main(String[] args){
		for(Profession profession : Profession.values()) {
			System.out.printf("%s\n", profession.getDesc());
		}
	}
}
