using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ChangeScene : MonoBehaviour {
	public void changeToScene(int scene)
	{
		Application.LoadLevel(scene);
	}
	public void quit()
	{
		Application.Quit();
	}
}