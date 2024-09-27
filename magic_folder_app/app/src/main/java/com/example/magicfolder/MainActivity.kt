
package com.example.magicfolder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.magicfolder.ui.screen.FolderScreen
import com.example.magicfolder.ui.theme.MagicFolderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicFolderTheme {
                MagicFolderApp()
            }
        }
    }
}

@Composable
fun MagicFolderApp() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var selectedScreen by remember { mutableStateOf(0) }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerMenu(
                onMenuItemClick = { index ->
                    selectedScreen = index
                    scope.launch { scaffoldState.drawerState.close() }
                }
            )
        },
        topBar = {
            TopAppBar(title = { Text("Magic Folder") })
        },
        content = {
            when (selectedScreen) {
                0 -> FolderScreen(folderIndex = 1)
                1 -> FolderScreen(folderIndex = 2)
                2 -> FolderScreen(folderIndex = 3)
            }
        }
    )
}

@Composable
fun DrawerMenu(onMenuItemClick: (Int) -> Unit) {
    Column {
        Text("Folder 1", modifier = Modifier.clickable { onMenuItemClick(0) })
        Text("Folder 2", modifier = Modifier.clickable { onMenuItemClick(1) })
        Text("Folder 3", modifier = Modifier.clickable { onMenuItemClick(2) })
    }
}
