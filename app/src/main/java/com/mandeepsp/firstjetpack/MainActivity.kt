package com.mandeepsp.firstjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mandeepsp.firstjetpack.ui.theme.FirstJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UserList()
                }
            }
        }
    }
}

@Composable
fun UserList() {
    val usersList = mutableListOf<User>(
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground),
        User("User A", "Description B", R.drawable.ic_launcher_foreground)
    )
    val listModifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(10.dp)

    LazyColumn(modifier = listModifier) {
        items(usersList) { model ->
            UserItem(user = model)
        }
    }

}

@Composable
fun UserItem(user: User) {
    Surface() {
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .border(1.dp,Color.Red, RoundedCornerShape(15.dp))
                .padding(5.dp)

        ) {
            Image(
                painter = painterResource(id = user.image),
                contentDescription = "Item Image",
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Hello ${user.title}", Toast.LENGTH_SHORT).show()
                }
            )
            Column(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = user
                        .title,
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.padding(all = 2.dp))
                Text(
                    text = user
                        .description,
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            }
        }
    }

}

@Preview(showBackground = true, name = "Default Preview")
@Composable
fun DefaultPreview() {
    FirstJetpackTheme {
//        Greeting("tittle demo", "descton demo", R.drawable.ic_launcher_foreground)
        UserList()
    }
}
