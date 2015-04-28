package personagens;
/**
 * Interface para implementação dos personagens
 * 
 * @author Johnny Stark
 *
 */
public interface IPersonagens {
	public void SetAtributos ();
	
	public void Render ();
	
	public void Damage_Heal (int modHP);
	
	public void CountXP (int modXP);
	
	public void LevelUp ();
	
}
