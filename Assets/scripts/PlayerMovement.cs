using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour {

    // the player
    public Rigidbody rb;

    // forces
    public float forwardForce = 1f;  // Variable that determines the forward force
    public float sidewaysForce = 1f;  // Variable that determines the sideways force

    // update the scene
    void FixedUpdate()
    {
        if (Input.GetKey("w"))  // If the player is pressing the "w" key
        {
            rb.MovePosition(rb.position + new Vector3(0f, 0f, 0.1f));
        }

        if (Input.GetKey("a"))  // If the player is pressing the "a" key
        {
            rb.MovePosition(rb.position + new Vector3(-.1f, 0f, 0f));
        }

        if (Input.GetKey("s"))  // If the player is pressing the "s" key
        {
            rb.MovePosition(rb.position + new Vector3(0f, 0f, -0.1f));
        }

        if (Input.GetKey("d"))  // If the player is pressing the "d" key
        {
            rb.MovePosition(rb.position + new Vector3(.1f, 0f, 0f));
        }

        if (rb.position.y <= 0) // If the player fell off the map
        {
            FindObjectOfType<GameManager>().EndGame(false);
        }
    }
}
