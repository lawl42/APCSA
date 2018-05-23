using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RandomGen : MonoBehaviour {
	//private bool pointCheck = false;
	
	//private int pointCount =0;
	//public GameObject guide;
	//public bool pickCheck = false;
	//private bool enterCheck = false;
	//private int timeLeft = 30;
	//public Transform goalPos;
	public GameObject item;
	//ublic GameObject item1;
	public Vector3 size;
	private GameObject instantiatedObj;

	//private RigidBody rb;

	// Update is called once per frame
	void Update () {
		//timer
		//playerPick();
	}
	/*void playerPick()
	{
		if(!pointCheck)
		{
			instantiatedObj = (GameObject) Instantiate(item, new Vector3(Random.Range(-size.x/2, size.x/2), .5f, Random.Range(-size.z/2, size.z/2)), new Quaternion (0,0,0,0));
			pointCheck = true;
		}

		if((Vector3.Distance(instantiatedObj.transform.position, transform.position) < 1.5) && !pickCheck)
		{
			Debug.Log("item has been picked");
			guide = (GameObject) Instantiate(item1, new Vector3(transform.position.x , transform.position.y, transform.position.z), new Quaternion (0,0,0,0));
			guide.transform.parent = gameObject.transform;
			instantiatedObj.SetActive(false);
			pickCheck = true;
		}
		if(pickCheck && enterCheck)
		{
			Debug.Log("yes");
			Destroy(guide);
			pointCheck = false;
			pickCheck = false;
			instantiatedObj.SetActive(true);
			pointCount++;
			enterCheck = false;
		}
	}
	*/

	public void gen()
	{
		instantiatedObj = (GameObject) Instantiate(item, new Vector3(Random.Range(-size.x/2, size.x/2), .5f, Random.Range(-size.z/2, size.z/2)), new Quaternion (0,0,0,0));

	}
	/*void OnCollisionEnter(Collision col)
	{
		if(col.gameObject.tag == "Goal")
		{
			enterCheck = true;
		}
	}*/
}
