package com.example.avatarapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.avatarapp.R
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AvatarScreen() {
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Avatar Face menggunakan Box untuk layering
        Box(
            modifier = Modifier.size(300.dp),
            contentAlignment = Alignment.Center
        ) {
            // Layer 1: wajah dasar (selalu tampil)
            Image(
                painter = painterResource(id = R.drawable.head),
                contentDescription = "Base face",
                modifier = Modifier.size(300.dp)
            )
            // Layer 2: alis
            if (showBrow) {
                Image(
                    painter = painterResource(id = R.drawable.brow),
                    contentDescription = "Brow",
                    modifier = Modifier
                        .size(width = 70.dp, height = 35.dp)
                        .offset(y=(-25).dp)
                )
            }
            // Layer 3: mata
            if (showEye) {
                Image(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = "Eye",
                    modifier = Modifier
                        .size(width = 70.dp, height = 35.dp)
                        .offset(y=(-20).dp)
                )
            }
            // Layer 4: hidung
            if (showNose) {
                Image(
                    painter = painterResource(id = R.drawable.nose),
                    contentDescription = "Nose",
                    modifier = Modifier
                        .size(width = 70.dp, height = 35.dp)
                        .offset(y=(0).dp)                )
            }
            // Layer 5: mulut
            if (showMouth) {
                Image(
                    painter = painterResource(id = R.drawable.mouth),
                    contentDescription = "Mouth",
                    modifier = Modifier
                        .size(width = 65.dp, height = 32.dp)
                        .offset(y=(20).dp)                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Checkboxes
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            AvatarCheckbox("Brow", showBrow) { showBrow = it }
            AvatarCheckbox("Eye", showEye) { showEye = it }
            AvatarCheckbox("Nose", showNose) { showNose = it }
            AvatarCheckbox("Mouth", showMouth) { showMouth = it }
        }
    }
}

@Composable
fun AvatarCheckbox(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AvatarScreenPreview() {
    AvatarScreen()
}