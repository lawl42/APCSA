using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class PlayerCollision : MonoBehaviour {
    public bool pickedUp = false;
	private int playerHealth = 5;
	private GameObject go;
	private int pointCount =0;

    void OnCollisionEnter(Collision col)
	{
		if (col.gameObject.tag == "Obstacle")
        {
			if (SceneManager.GetActiveScene().buildIndex == 0)
			{
				playerHealth--;
				Debug.Log(playerHealth);
			}
			else 
			{
				Debug.Log("trash");
				FindObjectOfType<GameManager>().Restart();
			}
        }
		if (col.gameObject.tag == "Pick Up")
        {
			if (SceneManager.GetActiveScene().buildIndex == 0)
			{
				pickedUp = true;
				col.gameObject.SetActive(false);	
				col.gameObject.tag = "Obstacle";
				go = col.gameObject;
			}
			else {
		        pickedUp = true;
				Destroy(col.gameObject);	
			}
        }
        
        if (col.gameObject.tag == "Finish")
        {
            if (pickedUp)
            {
				if (SceneManager.GetActiveScene().buildIndex == 0)
				{
					go.SetActive(true);
					FindObjectOfType<RandomGen>().gen();
					pointCount++;
					pickedUp = false;
				}
				else
				{
					Debug.Log("succ");
					FindObjectOfType<GameManager>().EndLevel();
				}
			}
        }

        
	}
}
