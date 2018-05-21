using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour {
    private int maxLevel = 2;

    public void EndGame(bool time)
    {
        if (time)
        {
            Debug.Log("time is up");
        }

        if (SceneManager.GetActiveScene().buildIndex == 0)
        {
            Debug.Log("BRUH U DED");
        }

        else
        {
            Debug.Log("noob");
            Restart();
        }
    }

    public void EndLevel()
    {
        
        if (SceneManager.GetActiveScene().buildIndex != maxLevel)
        {
            NextLevel();
        }

        else
        {
            Debug.Log("we done");
        }
    }

    public void Restart()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }

    public void NextLevel()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);
    }
}
