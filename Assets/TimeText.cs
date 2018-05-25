using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class TimeText : MonoBehaviour {
	public Text timeText;
	// Update is called once per frame
	void Update () {
		timeText.text = "Time Left:" + FindObjectOfType<Timer>().getTime().ToString();
	}
}
