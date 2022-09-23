import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@EnableAutoConfiguration
public class Main {

public String name = " ";
	


//===============================================================================================
//                  HOME PAGE
//===============================================================================================

    @RequestMapping(value = "/")
    @ResponseBody
    String home(@RequestParam(required=false, name = "name") String name) {
    	
    	if (name == null) {
    		name = " ";
    	}
    	
    	String template =
"<!DOCTYPE html>"+
"<html>"+
""+
"<style>"+
"    html {"+
"        height: 100%;"+
"       max-width: 100%;"+
"       overflow-x: hidden;"+
"    }"+
""+
"    body {"+
"        margin: 0;"+
"        padding: 0;"+
"        font-family: sans-serif;"+
"        background: linear-gradient(#141e30, #243b55);"+
"    }"+
""+
"    .login-box {"+
"        position: absolute;"+
"        top: 50%;"+
"        left: 50%;"+
"        width: 400px;"+
"        padding: 40px;"+
"        transform: translate(-50%, -50%);"+
"        background: rgba(0, 0, 0, .5);"+
"        box-sizing: border-box;"+
"        box-shadow: 0 15px 25px rgba(0, 0, 0, .6);"+
"        border-radius: 10px;"+
"    }"+
""+
"    .login-box h2 {"+
"        margin: 0 0 30px;"+
"        padding: 0;"+
"        color: #fff;"+
"        text-align: center;"+
"    }"+
""+
"    .login-box .user-box {"+
"        position: relative;"+
"    }"+
""+
"    .login-box .user-box input {"+
"        width: 100%;"+
"        padding: 10px 0;"+
"        font-size: 16px;"+
"        color: #fff;"+
"        margin-bottom: 30px;"+
"        border: none;"+
"        border-bottom: 1px solid #fff;"+
"        outline: none;"+
"        background: transparent;"+
"    }"+
""+
"    .login-box .user-box label {"+
"        position: absolute;"+
"        top: 0;"+
"        left: 0;"+
"        padding: 10px 0;"+
"        font-size: 16px;"+
"        color: #fff;"+
"        pointer-events: none;"+
"        transition: .5s;"+
"    }"+
""+
"    .login-box .user-box input:focus~label,"+
"    .login-box .user-box input:valid~label {"+
"        top: -20px;"+
"        left: 0;"+
"        color: #03e9f4;"+
"        font-size: 12px;"+
"    }"+
""+
"    .login-box form a {"+
"        position: relative;"+
"        display: inline-block;"+
"        color: #03e9f4;"+
"        font-size: 16px;"+
"        text-decoration: none;"+
"        text-transform: uppercase;"+
"        overflow: hidden;"+
"        transition: .5s;"+
"        margin-top: 40px;"+
"        letter-spacing: 4px;"+
"    }"+
""+
"    .login-box a:hover {"+
"        background: #03e9f4;"+
"        color: #fff;"+
"        border-radius: 5px;"+
"        box-shadow: 0 0 5px #03e9f4,"+
"            0 0 25px #03e9f4,"+
"            0 0 50px #03e9f4,"+
"            0 0 100px #03e9f4;"+
"    }"+
""+
"    .login-box a span {"+
"        position: absolute;"+
"        display: block;"+
"    }"+
""+
"    .login-box a span:nth-child(1) {"+
"        top: 0;"+
"        left: -100%;"+
"        width: 100%;"+
"        height: 2px;"+
"        background: linear-gradient(90deg, transparent, #03e9f4);"+
"        animation: btn-anim1 1s linear infinite;"+
"    }"+
""+
"    @keyframes btn-anim1 {"+
"        0% {"+
"            left: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            left: 100%;"+
"        }"+
"    }"+
""+
"    .login-box a span:nth-child(2) {"+
"        top: -100%;"+
"        right: 0;"+
"        width: 2px;"+
"        height: 100%;"+
"        background: linear-gradient(180deg, transparent, #03e9f4);"+
"        animation: btn-anim2 1s linear infinite;"+
"        animation-delay: .25s"+
"    }"+
""+
"    @keyframes btn-anim2 {"+
"        0% {"+
"            top: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            top: 100%;"+
"        }"+
"    }"+
""+
"    .login-box a span:nth-child(3) {"+
"        bottom: 0;"+
"        right: -100%;"+
"        width: 100%;"+
"        height: 2px;"+
"        background: linear-gradient(270deg, transparent, #03e9f4);"+
"        animation: btn-anim3 1s linear infinite;"+
"        animation-delay: .5s"+
"    }"+
""+
"    @keyframes btn-anim3 {"+
"        0% {"+
"            right: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            right: 100%;"+
"        }"+
"    }"+
""+
"    .login-box a span:nth-child(4) {"+
"        bottom: -100%;"+
"        left: 0;"+
"        width: 2px;"+
"        height: 100%;"+
"        background: linear-gradient(360deg, transparent, #03e9f4);"+
"        animation: btn-anim4 1s linear infinite;"+
"        animation-delay: .75s"+
"    }"+
""+
"    @keyframes btn-anim4 {"+
"        0% {"+
"            bottom: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            bottom: 100%;"+
"        }"+
"    }"+
""+
"    h1 {"+
"        text-align: center;"+
"        color: #fff;"+
"        font-size: 5em;"+
"        letter-spacing: 8px;"+
"        font-family: 'Press Start 2P';"+
"        font-weight: 400;"+
"        /*Create overlap*/"+
"        margin: 0;"+
"        line-height: 0;"+
"        /*Animation*/"+
""+
"        animation: glitch1 2.5s infinite;"+
"    }"+
""+
"    h1:nth-child(2) {"+
"        color: #67f3da;"+
"        animation: glitch2 2.5s infinite;"+
"    }"+
""+
"    h1:nth-child(3) {"+
"        color: #f16f6f;"+
"        animation: glitch3 2.5s infinite;"+
"    }"+
""+
"    /*Keyframes*/"+
""+
"    @keyframes glitch1 {"+
"        0% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        7% {"+
"            transform: skew(-0.5deg, -0.9deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        10% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        27% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        30% {"+
"            transform: skew(0.8deg, -0.1deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        35% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        52% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        55% {"+
"            transform: skew(-1deg, 0.2deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        50% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        72% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        75% {"+
"            transform: skew(0.4deg, 1deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        80% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        100% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
"    }"+
""+
"    @keyframes glitch2 {"+
"        0% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        7% {"+
"            transform: translate(-2px, -3px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        10% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        27% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        30% {"+
"            transform: translate(-5px, -2px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        35% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        52% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        55% {"+
"            transform: translate(-5px, -1px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        50% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        72% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        75% {"+
"            transform: translate(-2px, -6px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        80% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        100% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
"    }"+
""+
"    @keyframes glitch3 {"+
"        0% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        7% {"+
"            transform: translate(2px, 3px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        10% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        27% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        30% {"+
"            transform: translate(5px, 2px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        35% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        52% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        55% {"+
"            transform: translate(5px, 1px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        50% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        72% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        75% {"+
"            transform: translate(2px, 6px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        80% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        100% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
"    }"+
""+
"    .title_animation {"+
"        padding-top: 100px;"+
"    }"+
""+
"    #container {"+
"        overflow-wrap: break-word;"+
"        word-wrap: break-word;"+
"        hyphens: auto;"+
"        white-space: normal;"+
"    }"+
""+
"    .submit_button {"+
"        color: aliceblue;"+
"        background-color: Transparent;"+
"        background-repeat: no-repeat;"+
"        border: none;"+
"        cursor: pointer;"+
"        overflow: hidden;"+
"        outline: none;"+
"        height: 50px; "+
"        width: 100px;"+
"    }"+
""+
"    .error_output{"+
"    position: fixed;"+
"    bottom: 100px;"+
"    left:200px;"+
"    }"+
"</style>"+
""+
"<body>"+
"    <div class='title_animation'>"+
"        <div id='container'>"+
"            <h1>Andromeda</h1>"+
"            <h1>Andromeda</h1>"+
"            <h1>Andromeda</h1>"+
"        </div>"+
"    </div>"+
""+
""+
"    <div class='login-box'>"+
"        <h2>Login</h2>"+
"        <form action='/login' method='post'>"+
"            <div class='user-box'>"+
"                <input type='text' name='name' value='' placeholder='username'><br>"+
"            </div>"+
"            <div class='user-box'>"+
"                <input type='password'  value='' placeholder='password'><br>"+
"            </div>"+
"            <a href='#' class='submit_button_border'>"+
"                <span></span>"+
"                <span></span>"+
"                <span></span>"+
"                <span></span>"+
"                <input class='submit_button' type='submit' value='Submit'>"+
"            </a>"+
"        </form>"+
"    </div>"+
""+
"    <h2 class='error_output'></h2>"+
"</body>"+
"";
    	//dependent of the template engine
    	//https://freemarker.apache.org/docs/api/freemarker/cache/StringTemplateLoader.html
    	try {
			Template t = new Template("home", new StringReader(template), new Configuration());
			Writer out = new StringWriter();
	    	try {
				t.process(new HashMap<Object, Object>(),out);
			} catch (TemplateException e) {
				// TODO Return error or something else different from the template
				e.printStackTrace();
			}

	    	template = out.toString();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    	
    	    	
        return template;
    }
    	

//===============================================================================================
//                  ERROR PAGE
//===============================================================================================





    @RequestMapping(value = "/login")
    @ResponseBody
    String error_login_page(@RequestParam(required=false, name = "name") String name) {
    	
    	if (name == null) {
    		name = " ";
    	}
        name = name.replaceAll(",", " ");
        name = "No username "+name+" found. Please try again.";
    	
    	String template =
"<!DOCTYPE html>"+
"<html>"+
""+
"<style>"+
"    html {"+
"        height: 100%;"+
"    }"+
""+
"    body {"+
"        margin: 0;"+
"        padding: 0;"+
"        font-family: sans-serif;"+
"        background: linear-gradient(#141e30, #243b55);"+
"    }"+
""+
"    .login-box {"+
"        position: absolute;"+
"        top: 50%;"+
"        left: 50%;"+
"        width: 400px;"+
"        padding: 40px;"+
"        transform: translate(-50%, -50%);"+
"        background: rgba(0, 0, 0, .5);"+
"        box-sizing: border-box;"+
"        box-shadow: 0 15px 25px rgba(0, 0, 0, .6);"+
"        border-radius: 10px;"+
"    }"+
""+
"    .login-box h2 {"+
"        margin: 0 0 30px;"+
"        padding: 0;"+
"        color: #fff;"+
"        text-align: center;"+
"    }"+
""+
"    .login-box .user-box {"+
"        position: relative;"+
"    }"+
""+
"    .login-box .user-box input {"+
"        width: 100%;"+
"        padding: 10px 0;"+
"        font-size: 16px;"+
"        color: #fff;"+
"        margin-bottom: 30px;"+
"        border: none;"+
"        border-bottom: 1px solid #fff;"+
"        outline: none;"+
"        background: transparent;"+
"    }"+
""+
"    .login-box .user-box label {"+
"        position: absolute;"+
"        top: 0;"+
"        left: 0;"+
"        padding: 10px 0;"+
"        font-size: 16px;"+
"        color: #fff;"+
"        pointer-events: none;"+
"        transition: .5s;"+
"    }"+
""+
"    .login-box .user-box input:focus~label,"+
"    .login-box .user-box input:valid~label {"+
"        top: -20px;"+
"        left: 0;"+
"        color: #03e9f4;"+
"        font-size: 12px;"+
"    }"+
""+
"    .login-box form a {"+
"        position: relative;"+
"        display: inline-block;"+
"        color: #03e9f4;"+
"        font-size: 16px;"+
"        text-decoration: none;"+
"        text-transform: uppercase;"+
"        overflow: hidden;"+
"        transition: .5s;"+
"        margin-top: 40px;"+
"        letter-spacing: 4px;"+
"    }"+
""+
"    .login-box a:hover {"+
"        background: #03e9f4;"+
"        color: #fff;"+
"        border-radius: 5px;"+
"        box-shadow: 0 0 5px #03e9f4,"+
"            0 0 25px #03e9f4,"+
"            0 0 50px #03e9f4,"+
"            0 0 100px #03e9f4;"+
"    }"+
""+
"    .login-box a span {"+
"        position: absolute;"+
"        display: block;"+
"    }"+
""+
"    .login-box a span:nth-child(1) {"+
"        top: 0;"+
"        left: -100%;"+
"        width: 100%;"+
"        height: 2px;"+
"        background: linear-gradient(90deg, transparent, #03e9f4);"+
"        animation: btn-anim1 1s linear infinite;"+
"    }"+
""+
"    @keyframes btn-anim1 {"+
"        0% {"+
"            left: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            left: 100%;"+
"        }"+
"    }"+
""+
"    .login-box a span:nth-child(2) {"+
"        top: -100%;"+
"        right: 0;"+
"        width: 2px;"+
"        height: 100%;"+
"        background: linear-gradient(180deg, transparent, #03e9f4);"+
"        animation: btn-anim2 1s linear infinite;"+
"        animation-delay: .25s"+
"    }"+
""+
"    @keyframes btn-anim2 {"+
"        0% {"+
"            top: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            top: 100%;"+
"        }"+
"    }"+
""+
"    .login-box a span:nth-child(3) {"+
"        bottom: 0;"+
"        right: -100%;"+
"        width: 100%;"+
"        height: 2px;"+
"        background: linear-gradient(270deg, transparent, #03e9f4);"+
"        animation: btn-anim3 1s linear infinite;"+
"        animation-delay: .5s"+
"    }"+
""+
"    @keyframes btn-anim3 {"+
"        0% {"+
"            right: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            right: 100%;"+
"        }"+
"    }"+
""+
"    .login-box a span:nth-child(4) {"+
"        bottom: -100%;"+
"        left: 0;"+
"        width: 2px;"+
"        height: 100%;"+
"        background: linear-gradient(360deg, transparent, #03e9f4);"+
"        animation: btn-anim4 1s linear infinite;"+
"        animation-delay: .75s"+
"    }"+
""+
"    @keyframes btn-anim4 {"+
"        0% {"+
"            bottom: -100%;"+
"        }"+
""+
"        50%,"+
"        100% {"+
"            bottom: 100%;"+
"        }"+
"    }"+
""+
"    h1 {"+
"        text-align: center;"+
"        color: #fff;"+
"        font-size: 5em;"+
"        letter-spacing: 8px;"+
"        font-family: 'Press Start 2P';"+
"        font-weight: 400;"+
"        /*Create overlap*/"+
"        margin: 0;"+
"        line-height: 0;"+
"        /*Animation*/"+
""+
"        animation: glitch1 2.5s infinite;"+
"    }"+
""+
"    h1:nth-child(2) {"+
"        color: #67f3da;"+
"        animation: glitch2 2.5s infinite;"+
"    }"+
""+
"    h1:nth-child(3) {"+
"        color: #f16f6f;"+
"        animation: glitch3 2.5s infinite;"+
"    }"+
""+
"    /*Keyframes*/"+
""+
"    @keyframes glitch1 {"+
"        0% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        7% {"+
"            transform: skew(-0.5deg, -0.9deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        10% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        27% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        30% {"+
"            transform: skew(0.8deg, -0.1deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        35% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        52% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        55% {"+
"            transform: skew(-1deg, 0.2deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        50% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        72% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        75% {"+
"            transform: skew(0.4deg, 1deg);"+
"            opacity: 0.75;"+
"        }"+
""+
"        80% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
""+
"        100% {"+
"            transform: none;"+
"            opacity: 1;"+
"        }"+
"    }"+
""+
"    @keyframes glitch2 {"+
"        0% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        7% {"+
"            transform: translate(-2px, -3px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        10% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        27% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        30% {"+
"            transform: translate(-5px, -2px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        35% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        52% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        55% {"+
"            transform: translate(-5px, -1px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        50% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        72% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        75% {"+
"            transform: translate(-2px, -6px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        80% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        100% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
"    }"+
""+
"    @keyframes glitch3 {"+
"        0% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        7% {"+
"            transform: translate(2px, 3px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        10% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        27% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        30% {"+
"            transform: translate(5px, 2px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        35% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        52% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        55% {"+
"            transform: translate(5px, 1px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        50% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        72% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        75% {"+
"            transform: translate(2px, 6px);"+
"            opacity: 0.5;"+
"        }"+
""+
"        80% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
""+
"        100% {"+
"            transform: none;"+
"            opacity: 0.25;"+
"        }"+
"    }"+
""+
"    .title_animation {"+
"        padding-top: 100px;"+
"    }"+
""+
"    #container {"+
"        overflow-wrap: break-word;"+
"        word-wrap: break-word;"+
"        hyphens: auto;"+
"        white-space: normal;"+
"    }"+
""+
"    .submit_button {"+
"        color: aliceblue;"+
"        background-color: Transparent;"+
"        background-repeat: no-repeat;"+
"        border: none;"+
"        cursor: pointer;"+
"        overflow: hidden;"+
"        outline: none;"+
"        height: 50px; "+
"        width: 100px;"+
"    }"+
""+
"    .error_output{"+
"    color: #FEDB39;"+
"    font-size: 10px;"+
"    }"+
"</style>"+
""+
"<body>"+
"    <div class='title_animation'>"+
"        <div id='container'>"+
"            <h1>Andromeda</h1>"+
"            <h1>Andromeda</h1>"+
"            <h1>Andromeda</h1>"+
"        </div>"+
"    </div>"+
""+
""+
"    <div class='login-box'>"+
"        <h2>Login</h2>"+
"        <form action='/login' method='post'>"+
"            <div class='user-box'>"+
"                <input type='text' name='name' value='' placeholder='username'><br>"+
"            </div>"+
"            <div class='user-box'>"+
"                <input type='password' value='' placeholder='password'><br>"+
"            </div>"+
"            <p class='error_output'>"+name+"</p>"+
"            <a href='#' class='submit_button_border'>"+
"                <span></span>"+
"                <span></span>"+
"                <span></span>"+
"                <span></span>"+
"                <input class='submit_button' type='submit' value='Submit'>"+
"            </a>"+
"        </form>"+
"        <p class='error_output'>"+
"        Last Logon: Friday, September, 2022 14:32:27"+
"        </p>"+
"    </div>"+
""+
"</body";
    	//dependent of the template engine
    	//https://freemarker.apache.org/docs/api/freemarker/cache/StringTemplateLoader.html
    	try {
			Template t = new Template("error_login_page", new StringReader(template), new Configuration());
			Writer out = new StringWriter();
	    	try {
				t.process(new HashMap<Object, Object>(),out);
			} catch (TemplateException e) {
				// TODO Return error or something else different from the template
				e.printStackTrace();
			}

	    	template = out.toString();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    	
    	    	
        return template;
    }

    	


    public static void main(String[] args) throws Exception {
    	System.getProperties().put( "server.port", 5051 );
        SpringApplication.run(Main.class, args);
    }
}
