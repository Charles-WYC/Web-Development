<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\Bookdetail */

$this->title = 'Update Bookdetail: ' . $model->bookID;
$this->params['breadcrumbs'][] = ['label' => 'Bookdetails', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->bookID, 'url' => ['view', 'id' => $model->bookID]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="bookdetail-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
