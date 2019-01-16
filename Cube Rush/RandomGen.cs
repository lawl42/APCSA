using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RandomGen : MonoBehaviour {
	public GameObject item;
	public Vector3 size;
	private GameObject instantiatedObj;

	public void gen()
	{
		instantiatedObj = (GameObject) Instantiate(item, new Vector3(Random.Range(-size.x/2, size.x/2), .5f, Random.Range(-size.z/2, size.z/2)), new Quaternion (0,0,0,0));

	}
}