using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class scoreText : MonoBehaviour {
	public Text scoreTex;
	// Update is called once per frame
	void Update () {
		scoreTex.text = "Score :" + FindObjectOfType<PlayerCollision>().getPointCount().ToString();
	}
}