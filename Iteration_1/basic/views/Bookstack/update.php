<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\Bookstack */

$this->title = 'Update Bookstack: ' . $model->bookID;
$this->params['breadcrumbs'][] = ['label' => 'Bookstacks', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->bookID, 'url' => ['view', 'id' => $model->bookID]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="bookstack-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
