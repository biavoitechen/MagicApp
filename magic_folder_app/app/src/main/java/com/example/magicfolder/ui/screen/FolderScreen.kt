
package com.example.magicfolder.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FolderScreen(folderIndex: Int) {
    Column {
        Text("Folder $folderIndex", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(15) { index ->
                CardItem(cardIndex = index)
            }
        }
    }
}

@Composable
fun CardItem(cardIndex: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Card $cardIndex", style = MaterialTheme.typography.subtitle1)
            Row {
                Button(onClick = { /* Add card logic */ }) {
                    Text("Add")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Remove card logic */ }) {
                    Text("Remove")
                }
            }
        }
    }
}
