package com.majid2851.motionlayoutanimation_3buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene

@OptIn(ExperimentalMotionApi::class)
@Composable
fun ButtonMotion()
{
    val context= LocalContext.current
    val motionScene=remember{
        context.resources.openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    var animtaionButton by remember()
    {
        mutableStateOf(false)
    }
    val animatedProgress by animateFloatAsState(
            targetValue =if(animtaionButton) 1f else 0f,
            animationSpec = tween(durationMillis = 1000
        )
    )
    
    MotionLayout(
        motionScene =MotionScene(content = motionScene),
        progress = animatedProgress,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
    {
         Button(
             onClick = {animtaionButton=!animtaionButton},
             modifier = Modifier.layoutId("button1")
         ) {
            Text("Button1")
         }

        Button(
            onClick = {animtaionButton=!animtaionButton},
            modifier = Modifier.layoutId("button2")
        ) {
            Text("Button2")
        }
        Button(
            onClick = {animtaionButton=!animtaionButton},
            modifier = Modifier.layoutId("button3")
        ) {
            Text("Button3")
        }
    }



}

