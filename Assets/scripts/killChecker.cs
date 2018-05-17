using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class killChecker : MonoBehaviour {

	public int pickNum = 0;
	public CharacterMovement1 player;
	void OnCollisionEnter(Collision Col)
	{
		int playerDec = 0;
		playerDec++;
		Debug.Log(playerDec);
		if(pickNum > 0)
		{
			player.hurtPlayer(playeDec);
		}
		if(col.GameObject.name == "Capsule")
		{
			pickNum++;
		}
	}
}
