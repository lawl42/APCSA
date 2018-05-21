using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerCollision : MonoBehaviour {
    public bool pickedUp = false;

    void OnCollisionEnter(Collision col)
	{
		if (col.gameObject.tag == "Pick Up")
        {
            pickedUp = true;
            Destroy(col.gameObject);
        }
        
        if (col.gameObject.tag == "Finish")
        {
            if (pickedUp)
            {
                Debug.Log("succ");
                FindObjectOfType<GameManager>().EndLevel();
            }
        }

        if (col.gameObject.tag == "Obstacle")
        {
            Debug.Log("trash");
            FindObjectOfType<GameManager>().Restart();
        }
	}
}
