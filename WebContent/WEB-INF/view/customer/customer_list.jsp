
<style>

.table1 {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  padding: 8px 8px;
  border: 1px solid #ddd;
  margin-left: 200px;
  margin-right:200px;
}

.table1 td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;

}

.table1 tr:nth-child(even) {
  background-color: #eeeeee;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 4px 4px;
}

.pagination a.active {
  background-color: #45a049;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #4CAF50;}
</style>


<div class="table1">
<table>
  <tr>
  	<th>No.</th>
    <th>Customer ID</th>
    <th>Name</th>
    <th>Address</th>
    <th>City</th>
    <th>Postal-code</th>
    <th>Country</th>
  </tr>
  <tr>
  	<td>1</td>
    <td>Test1823</td>
    <td>Maria Anders</td>
    <td>Germany</td>
    <td>Mola</td>
    <td>82524</td>
    <td>AfricaAmerica</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Francisco Chang</td>
    <td>Mexico</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>3</td>
    <td>Roland Mendel</td>
    <td>Austria</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>4</td>
    <td>Helen Bennett</td>
    <td>UK</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>5</td>
    <td>Yoshi Tannamuri</td>
    <td>Canada</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>6</td>
    <td>Giovanni Rovelli</td>
    <td>Italy</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>
</div>

<div class="pagination">
  <a href="#">&laquo;</a>
  <a href="#">1</a>
  <a href="#">2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">6</a>
  <a href="#">&raquo;</a>
</div>



