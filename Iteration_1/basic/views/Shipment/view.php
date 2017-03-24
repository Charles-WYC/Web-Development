<?php

use yii\helpers\Html;
use yii\widgets\DetailView;

/* @var $this yii\web\View */
/* @var $model app\models\Shipment */

$this->title = $model->bookID;
$this->params['breadcrumbs'][] = ['label' => 'Shipments', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="shipment-view">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a('Update', ['update', 'bookID' => $model->bookID, 'indentID' => $model->indentID], ['class' => 'btn btn-primary']) ?>
        <?= Html::a('Delete', ['delete', 'bookID' => $model->bookID, 'indentID' => $model->indentID], [
            'class' => 'btn btn-danger',
            'data' => [
                'confirm' => 'Are you sure you want to delete this item?',
                'method' => 'post',
            ],
        ]) ?>
    </p>

    <?= DetailView::widget([
        'model' => $model,
        'attributes' => [
            'bookID',
            'indentID',
            'number',
        ],
    ]) ?>

</div>
