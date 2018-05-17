using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class characterMovement1 : MonoBehaviour {
	private float gravity = 30f;
	private float jumpSpeed = 10f;
	private float speed = 10f;
	private float verticalVelocity = 0;
	//object that will deactivate when picked
	private GameObject instantiatedObj;
	//position of player
    public Vector3 playerPos;
	//Instance of item 
	public GameObject item;
	//clone of item
	public GameObject guide;
	//position of goal
	public Transform goalPos;
	//size of plane
    public Vector3 size;
	private int pointCount = 0;
	//if item is not on floor
	private bool pointCheck = false;
	//if player is holding item
	private bool pickCheck = true;
	//private bool wCheck = false;
	//private bool sCheck = false;
	//private bool eCheck = false;
	//private bool aCheck = false;
	void FixedUpdate () {
		//rayEmit();
		playerPick();
		CharacterController controller = GetComponent<CharacterController>();
		if(controller.isGrounded)
		{
			if(Input.GetButton("Jump"))
			{
				verticalVelocity = jumpSpeed;
			}
		}
		else
		{
			verticalVelocity -= gravity * Time.deltaTime;
		}
		Vector3 movement = new Vector3(Input.GetAxis("Horizontal") *speed, verticalVelocity, Input.GetAxis("Vertical") * speed);
		movement = transform.TransformDirection(movement);
		controller.Move(movement * Time.deltaTime);
	}
	void playerPick()
	{
		if(!pointCheck)
		{
			instantiatedObj = (GameObject) Instantiate(item, new Vector3(Random.Range(-size.x/2, size.x/2), .5f, Random.Range(-size.z/2, size.z/2)), new Quaternion (0,0,0,0));
			pointCheck = true;
		}

		if((Vector3.Distance(instantiatedObj.transform.position, transform.position) < 1.5) && pickCheck)
		{
			Debug.Log("item has been picked");
			guide = (GameObject) Instantiate(item, new Vector3(transform.position.x , transform.position.y, transform.position.z), new Quaternion (0,0,0,0));
			guide.transform.parent = gameObject.transform;
			instantiatedObj.SetActive(false);
			pickCheck = false;
		}
		if(!pickCheck && Vector3.Distance(goalPos.position, transform.position) < 1.5)
		{
			Destroy(guide);
			pointCheck = false;
			pickCheck = true;
			instantiatedObj.SetActive(true);
			pointCount++;
		}
	}
	}
	
	/*void rayEmit()
	{
		playerEnd = transform.position;
        playerEnd.y = .3f;
        if(Input.GetKey(KeyCode.W))
        {
            playerEnd.z += .7f;
            var guide = Instantiate(rayGuide, playerEnd, new Quaternion (0,0,0,0));
			guide.transform.parent = gameObject.transform;
        }
		if(Input.GetKey(KeyCode.S))
        {
            playerEnd.z += -.7f;
            var guide = Instantiate(rayGuide, playerEnd, new Quaternion (0,0,0,0));
			guide.transform.parent = gameObject.transform;
        }
		if(Input.GetKey(KeyCode.A))
        {
            playerEnd.x += -.7f;
            var guide = Instantiate(rayGuide, playerEnd, new Quaternion (0,0,0,0));
			guide.transform.parent = gameObject.transform;
        }
		if(Input.GetKey(KeyCode.D))
        {
            playerEnd.x += .7f;
            var guide = Instantiate(rayGuide, playerEnd, new Quaternion (0,0,0,0));
			guide.transform.parent = gameObject.transform;
        }
	}
 }*/

