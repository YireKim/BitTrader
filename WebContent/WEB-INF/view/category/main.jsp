<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

<style>
.wrapper > div {
  border: 2px;
  border-radius: 5px;
  padding: 1em;
}
.wrapper {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  grid-gap: 8px;
  grid-auto-rows: minmax(100px, auto);
}
.box1{
	grid-column: 2 / 12;
	grid-row: 1;
}
.box2 {
	grid-column: 2 / 5;
	grid-row: 2;
}
.box3 {
	grid-column: 5 / 9;
	grid-row: 2;
}
.box4 {
	grid-column: 9 / 12;
	grid-row: 2;
}
</style>
<div class="wrapper">
<div class="box1">
        <div class="thumbnail">
        <img src="${imgpath}corp.jpeg" alt="" />
          <div class="caption">
            <h3 id="thumbnail-label">Mac</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
      <div class="box2">
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="${imgpath}macpro.jpeg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Laptop<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
      <div class="box3">
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="${imgpath}imac.jpeg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Desktop<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p>Cras justo odio, dapibus ac facilisis in, egests ac facilisis in, egests ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
      <div class="box4">
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="${imgpath}ipadpro.jpeg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Tablet<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
</div>
<jsp:include page="../home/tail.jsp" />
