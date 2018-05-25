using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class scoreEndText : MonoBehaviour {
	public Text scoreText;
	
	public void setScore(int score) {
			Debug.Log("uasdf");
			scoreText.text = "Score :" + score.ToString();
	}
}
