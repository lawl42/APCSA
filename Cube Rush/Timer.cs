using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Timer : MonoBehaviour {
	float timeLeft = 30;
	
	// Update is called once per frame
	void Update () {
		timeLeft -= Time.deltaTime;
		if(timeLeft <= 0)
		{
			FindObjectOfType<GameManager>().EndGame(true);
		}
	}
	public int getTime()
	{
		return (int)timeLeft;
	}
}