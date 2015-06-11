package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.Random;
import java.util.ArrayList;


public class DirectorSkills {
	
	public void construct(ArrayList<Skill> skills, AbsPersonagem vilao){
		int indice = 0;
		Random random = new Random();
		AtaqueBasico basic = new AtaqueBasico();
		vilao.skill0 = basic;
		
		while(skills.get(indice).tipoSkill != vilao.tipo)
			indice = random.nextInt(19) + 1;
		vilao.skill1 = skills.get(indice);
		skills.remove(indice);
		
		while(skills.get(indice).tipoSkill != vilao.tipo)
			indice = random.nextInt(18) + 1;
		vilao.skill2 = skills.get(indice);
		skills.remove(indice);
		
		while(skills.get(indice).tipoSkill != vilao.tipo)
			indice = random.nextInt(17) + 1;
		vilao.skill3 = skills.get(indice);
		skills.remove(indice);
	}

}