/**
 * 
 */
package topdesk;

/**
 * @author Szabi
 *
 */
public class SmartField implements Position {

	private Field field;
	private FieldStatus fieldstatus;
	
	public SmartField(Field field, FieldStatus fieldstatus) {
		this.field=field;
		this.fieldstatus=fieldstatus;
	}
	
	public SmartField(String field, FieldStatus fieldstatus) {
		this.field=Field.valueOf(field);
		this.fieldstatus=fieldstatus;
	}
	
	
	public FieldStatus getFieldStatus(){
		return fieldstatus;
	}
	
	public void setFieldStatus(FieldStatus fieldstatus){
		if(fieldstatus.equals(FieldStatus.EMPTY)){
			this.fieldstatus=fieldstatus;
		} else{//KICSERÉLNI KÓDRA KICSERÉLNI KÓDRA KICSERÉLNI KÓDRA
			System.out.println("throw an exception, already used");
		}
		
	}
	
	public Field getField(){
		return field;
	}

	@Override
	public FieldStatus getFieldStatus(Field field) {
		// TODO Auto-generated method stub
		return fieldstatus;
	}
}
