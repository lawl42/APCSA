using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour {
    private int maxLevel = 4;

    public void EndGame(bool time)
    {
        if (time)
        {
            Application.LoadLevel(maxLevel + 2); 
        }

        else if (SceneManager.GetActiveScene().buildIndex == maxLevel + 1)
        {
            Application.LoadLevel(maxLevel + 2);
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
            Application.LoadLevel(0);
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