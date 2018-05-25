using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class PlayerCollision : MonoBehaviour {
    public bool pickedUp = false;
	public int playerHealth = 5;
	private GameObject go;
	public int pointCount =0;
	private int numLevels = 4;

    void OnCollisionEnter(Collision col)
	{
		if (col.gameObject.tag == "Obstacle")
        {
			if (SceneManager.GetActiveScene().buildIndex == numLevels+1)
			{
				playerHealth--;
				if(playerHealth <= 0)
				{
					Debug.Log("u luse");
					FindObjectOfType<scoreEndText>().setScore(pointCount);
					FindObjectOfType<GameManager>().EndGame(false);
				}
			}
			else 
			{
				Debug.Log("trash");
				FindObjectOfType<GameManager>().Restart();
			}
        }
		if (col.gameObject.tag == "Pick Up")
        {
			if (SceneManager.GetActiveScene().buildIndex == numLevels+1)
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
				if (SceneManager.GetActiveScene().buildIndex == numLevels+1)
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
		public int getHealth()
		{
			return playerHealth;
		}
		public bool getPickedUp()
		{
			return pickedUp;
		}
		public int getPointCount()
		{
			return pointCount;
		}
}
