using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour {

    // the player
    public Rigidbody rb;

    // forces
    public float force;  // Variable that determines the force 
    // update the scene
    void FixedUpdate()
    {
        if (Input.GetKey("w"))  // If the player is pressing the "w" key
        {
            rb.MovePosition(rb.position + new Vector3(0f, 0f, force));
			
		}

        if (Input.GetKey("a"))  // If the player is pressing the "a" key
        {
            rb.MovePosition(rb.position + new Vector3((-1)*force, 0f, 0f));
        }

        if (Input.GetKey("s"))  // If the player is pressing the "s" key
        {
            rb.MovePosition(rb.position + new Vector3(0f, 0f, (-1)*force));
        }

        if (Input.GetKey("d"))  // If the player is pressing the "d" key
        {
            rb.MovePosition(rb.position + new Vector3(force, 0f, 0f));
        }

        if (rb.position.y <= 0) // If the player fell off the map
        {
            FindObjectOfType<GameManager>().EndGame(false);
        }
    }
}
