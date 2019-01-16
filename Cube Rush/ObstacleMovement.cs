using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObstacleMovement : MonoBehaviour {
    public Rigidbody rb;
    private bool left = true;
	
	// Update is called once per frame
	void Update () {
        if (rb.position.x > -8f && left)
        {
            rb.MovePosition(rb.position - new Vector3(.1f, 0f, 0f));
        }
        else if (rb.position.x <= -8f && left)
        {
            left = false;
        }
        else if (rb.position.x < -5f && !left)
        {
            rb.MovePosition(rb.position + new Vector3(.1f, 0f, 0f));
        }
        else if (rb.position.x >= -5f && !left)
        {
            left = true;
        }
    }
}